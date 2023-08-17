package dqualizer.research.dqapi.models.rqa.loadtest.stimulus;

import dqualizer.research.dqapi.models.rqa.enums.*;

import java.util.Map;

public class StimulusFactory {
    public static Stimulus createStimulus(String loadProfileStr, Map<String, String> parameters, int accuracy) {
        LoadProfile loadProfile = LoadProfile.valueOf(loadProfileStr);
        switch (loadProfile) {
            case LOAD_PEAK:
                HighestLoad highestLoad = HighestLoad.valueOf(parameters.get("highest_load"));
                TimeToHighestLoad timeToHighestLoad = TimeToHighestLoad.valueOf(parameters.get("time_to_highest_load"));
                LoadPeakStimulus loadPeak = new LoadPeakStimulus();
                loadPeak.setAccuracy(accuracy);
                loadPeak.setLoadProfile(loadProfile);
                loadPeak.setHighestLoad(highestLoad);
                loadPeak.setTimeToHighestLoad(timeToHighestLoad);
                return loadPeak;
            case LOAD_INCREASE:
                TypeOfIncrease typeOfIncrease = TypeOfIncrease.valueOf(parameters.get("type_of_increase"));
                LoadIncreaseStimulus loadIncrease = new LoadIncreaseStimulus();
                loadIncrease.setAccuracy(accuracy);
                loadIncrease.setLoadProfile(loadProfile);
                loadIncrease.setTypeOfIncrease(typeOfIncrease);
                return loadIncrease;
            case CONSTANT_LOAD:
                BaseLoad baseLoad = BaseLoad.valueOf(parameters.get("base_load"));
                ConstantLoadStimulus constantLoad = new ConstantLoadStimulus();
                constantLoad.setLoadProfile(loadProfile);
                constantLoad.setAccuracy(accuracy);
                constantLoad.setBaseLoad(baseLoad);
                return constantLoad;
            default:
                throw new IllegalArgumentException("Invalid load profile: " + loadProfile);
        }
    }
}

