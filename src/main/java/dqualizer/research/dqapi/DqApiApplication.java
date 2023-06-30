package dqualizer.research.dqapi;

import dqualizer.research.dqapi.repositories.RqaDefinitionRepository;
import dqualizer.research.dqapi.models.rqa.RqaDefinition;
import dqualizer.research.dqapi.models.rqa.RuntimeQualityAnalysis;
import dqualizer.research.dqapi.models.rqa.enums.Environment;
import dqualizer.research.dqapi.models.rqa.loadtest.Loadtest;
import dqualizer.research.dqapi.services.RuntimeQualityAnalysisService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DqApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DqApiApplication.class, args);
	}

	@Bean
	CommandLineRunner RqaInsert(RqaDefinitionRepository rqaDefinitionRepository, RuntimeQualityAnalysisService service) {
		return arg -> {
			String name = "Loadtest Rqa Definition";
			String version = "v1";
			Environment environment = Environment.DEV;
			List<Loadtest> loadtests = new ArrayList<>();
			RuntimeQualityAnalysis runtimeQualityAnalysis = new RuntimeQualityAnalysis();
			RqaDefinition rqaDefinition = new RqaDefinition(name, version, environment, runtimeQualityAnalysis);

			rqaDefinitionRepository.insert(rqaDefinition);

		};

		}

}
