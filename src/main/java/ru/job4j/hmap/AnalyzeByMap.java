package ru.job4j.hmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects > 0 ? totalScore / totalSubjects : 0D;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double averageScore = pupil.subjects().isEmpty() ? 0 : totalScore / pupil.subjects().size();
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        double maxTotalScore = Double.MIN_VALUE;
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (totalScore > maxTotalScore) {
                maxTotalScore = totalScore;
                best = new Label(pupil.name(), totalScore);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }

        Label best = null;
        double maxTotalScore = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            if (entry.getValue() > maxTotalScore) {
                maxTotalScore = entry.getValue();
                best = new Label(entry.getKey(), maxTotalScore);
            }
        }
        return best;
    }
}
