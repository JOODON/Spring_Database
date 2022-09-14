package Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
//구성 시스템이라는걸 선언!
@Import({DBConfig.class})
//설정 파일을 여러개로 나누어주려고 가져오려고 그니깐 필요한것만 가져오려고하는것!
public class ApplicationConfig {

}
