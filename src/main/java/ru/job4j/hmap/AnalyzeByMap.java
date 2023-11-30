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
            double averageScore = pupil.subjects().stream()
                    .mapToInt(Subject::score)
                    .average()
                    .orElse(0D);

            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> subjectScores = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), (double) subject.score(), Double::sum);
                subjectCounts.merge(subject.name(), 1, Integer::sum);
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Double> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            int count = subjectCounts.get(subjectName);
            double averageScore = totalScore / count;
            result.add(new Label(subjectName, averageScore));
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
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            if (totalScore > maxTotalScore) {
                maxTotalScore = totalScore;
                best = new Label(subjectName, totalScore);
            }
        }
        return best;
    }
}
