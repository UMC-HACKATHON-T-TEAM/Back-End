package UMC_Hackathon.DailyMate.service.RecommendService;

import UMC_Hackathon.DailyMate.converter.FortuneConverter;
import UMC_Hackathon.DailyMate.converter.RecommendConverter;
import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.domain.Weather;
import UMC_Hackathon.DailyMate.repository.FortuneRepository;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.repository.WeatherRepository;
import UMC_Hackathon.DailyMate.web.dto.Chatgpt.ChatGPTRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.Chatgpt.ChatGPTResponseDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecommendCommandServiceImpl implements RecommendCommandService {

    private final UserRepository userRepository;
    private final FortuneRepository fortuneRepository;
    private final WeatherRepository weatherRepository;
    private final ScheduleRepository scheduleRepository;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    // ChatGPT API 요청
    public String getResponseOfChatGptApi(String systemPrompt, String userPrompt){
        // request를 api로 보내 chatGPT응답받기
        ChatGPTRequestDTO chatGPTrequest = new ChatGPTRequestDTO(model, systemPrompt,userPrompt);
        ChatGPTResponseDTO chatGPTResponse =  template.postForObject(apiURL, chatGPTrequest, ChatGPTResponseDTO.class);

        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    public RecommendResponseDTO.RecommendResultDTO CreateRecommendAndPostFortune(RecommendRequestDTO.CreateRecommendAndPostFortuneRequestDTO request){

        Users user = userRepository.findById(request.getUserId()).orElse(null);
        String gender = "";
        switch (user.getGender()) {
            case MALE:
                gender = "남";
                break;
            case FEMALE:
                gender = "여";
                break;
        }

        String systemPrompt = "사용자의 운세에 대해 알려줄 때 다음 사용자 정보에 관해서 알려줘\n"
                + "사용자 이름: " + user.getName()
                + "\n사용자 생년월일: " + user.getBirthday()
                + "\n사용자 성별: " + gender;
        String userPrompt = "다른 미사여구 없이 단답으로 오늘이 사주에서 무슨 일인지만 알려줘\n"
                + "답변 예시는 아래와 같아\n"
                + "경진일 (庚辰日)";
        String messageDateName = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageDateName);

        userPrompt = "다른 미사여구 없이 사용자의 오늘의 운세 점수를 알려줘\n"
                + "답변 예시는 아래와 같아\n"
                + "85";
        String messageFortunePoint = getResponseOfChatGptApi(systemPrompt, userPrompt);
        Integer point = Integer.parseInt(messageFortunePoint);
        System.out.println(messageFortunePoint);

        userPrompt = "사용자의 오늘의 운세에 대해 알려줘\n"
                + "운세 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같고 예시와 다르게 답변해줘\n"
                + "오늘은 긍정적인 에너지가 가득한 하루가 될 것입니다. 새로운 기회를 잘 살펴보세요. 직관을 믿고 행동하면 좋은 결과를 얻을 수 있을 것입니다. 주변 사람들과의 소통이 원활해져 도움을 주고받을 수 있는 기회도 많아질 것입니다. 언제나 긍정적인 마음을 유지하세요. 좋은 하루 되세요!\n";
        String messageFortune = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageFortune);

        userPrompt = "사용자의 오늘의 운세 중 행운을 가져다 줄 색깔 1개에 대해 알려줘. 색깔과 설명 가운데에 하이폰으로 구분해서 답해줘\n"
                + "색깔과 설명 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같고 예시와 다르게 답변해줘\n"
                + "파랑 - 침착함을 유지하는 데 도움이 됩니다.";
        String messageColor1 = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageColor1);

        userPrompt = messageColor1 + "에 해당하는 HexCode를 알려줘\n"
                + "HexCode 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같아\n"
                + "#000000";
        String messageColor1HexCode = getResponseOfChatGptApi("", userPrompt);
        System.out.println(messageColor1HexCode);

        userPrompt = "사용자의 오늘의 운세 중 행운을 가져다 줄 색깔 1개에 대해 알려줘. 색깔과 설명 가운데에 하이폰으로 구분해서 답해줘\n"
                + "색깔과 설명 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같고 예시와 다르게 답변해줘\n"
                + "초록 - 새로운 시작과 성장을 촉진합니다.";
        String messageColor2 = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageColor2);

        userPrompt = messageColor2 + "에 해당하는 HexCode를 알려줘\n"
                + "HexCode 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같아\n"
                + "#000000";
        String messageColor2HexCode = getResponseOfChatGptApi("", userPrompt);
        System.out.println(messageColor2HexCode);

        userPrompt = "사용자의 오늘의 운세 중 행운을 가져다 줄 아이템 1개에 대해 알려줘. 아이템과 설명 가운데에 하이폰으로 구분해서 답해줘\n"
                + "아이템과 설명 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같고 예시와 다르게 답변해줘\n"
                + "행운의 열쇠고리 - 이 열쇠고리는 당신에게 긍정적인 에너지를 불러오고, 운을 상승시켜줍니다.";
        String messageItem1 = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageItem1);

        userPrompt = "사용자의 오늘의 운세 중 행운을 가져다 줄 아이템 1개에 대해 알려줘. 아이템과 설명 가운데에 하이폰으로 구분해서 답해줘\n"
                + "아이템과 설명 이외의 답변은 하지 말아줘.\n"
                + "답변할 예시는 다음과 같고 예시와 다르게 답변해줘\n"
                + "크리스탈 팔찌 - 이 팔찌는 당신의 내면의 평화와 균형을 유지하는 데 도움을 주며, 좋은 기운을 끌어들입니다.";
        String messageItem2 = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(messageItem2);

        if(fortuneRepository.findByUsers(user) != null){
            fortuneRepository.deleteByUsers(user);
        }
        fortuneRepository.save(FortuneConverter.toFortune(user, messageDateName, point, messageFortune, messageColor1, messageColor1HexCode, messageColor2, messageColor2HexCode, messageItem1, messageItem2));

        // 날씨 정보 가져오기
        Weather weather = weatherRepository.findByUsers(user);
        String temperature = weather.getTemperature().toString();
        String weatherCondition = weather.getWeatherCondition().toString();

        // 해당 날짜의 일정 모두 가져오기
        List<Schedules> schedulesList = scheduleRepository.findByUsersAndDate(user, LocalDate.now());
        List<String> titles = schedulesList.stream()
                .map(Schedules::getTitle) // getTitle() 호출
                .collect(Collectors.toList());

        // 운세정보 가져오기 - ChatGPT로 가져온 값 사용.

        // ChagGPT로 옷차림 추천받기
        String color1 = messageColor1.split(" - ")[0];
        String color2 = messageColor1.split(" - ")[0];
        String item1 = messageColor1.split(" - ")[0];
        String item2 = messageColor1.split(" - ")[0];
        systemPrompt = "";
        userPrompt = "아래의 날씨 정보와 일정 그리고 운세정보(행운의 색과 아이템)에 따라 카테고리별로 입을만한 옷을 추천해줘\n"
                + "날씨 정보 - 기온: 섭씨" + temperature + ", 날씨: " + weatherCondition + "\n"
                + "일정 정보 : " + titles + "\n"
                + "행운의 색 : " + color1 + ", " + color2 + " 행운의 아이템: " + item1 + ", " + item2 + "\n"
                + "옷 카테고리 : Outer, Top, Bottom, ACC"
                + "답변 예시는 아래와 같아\n"
                + "Outer : 롱 패딩\nTop : 흰색 맨투맨\nBottom : 조거 팬츠\nACC : 목도리, 장갑, 실버링\n\n"
                + "답변 예시와 같은 형식 이외의 말은 제외시키고 답해줘 그리고 답변예시의 형식과 정확히 동일하게 답해줘";
        String recommend = getResponseOfChatGptApi(systemPrompt, userPrompt);
        System.out.println(recommend);

        return RecommendConverter.toRecommendResultDTO(messageFortunePoint, messageDateName, recommend);
    }

    public Fortune GetFortune(Long userId) {
        Users user = userRepository.findById(userId).orElse(null);
        return fortuneRepository.findByUsers(user);
    }
}
