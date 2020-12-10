package com.synopsys.integration.detector.evaluation;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.synopsys.integration.detectable.Detectable;
import com.synopsys.integration.detectable.DetectableEnvironment;
import com.synopsys.integration.detectable.detectable.exception.DetectableException;
import com.synopsys.integration.detectable.detectable.result.DetectableResult;
import com.synopsys.integration.detectable.detectable.result.PassedDetectableResult;
import com.synopsys.integration.detectable.extraction.ExtractionEnvironment;
import com.synopsys.integration.detector.base.DetectorEvaluation;
import com.synopsys.integration.detector.base.DetectorEvaluationTree;
import com.synopsys.integration.detector.result.DetectorResult;
import com.synopsys.integration.detector.rule.DetectorRule;
import com.synopsys.integration.detector.rule.DetectorRuleSet;

public class ExtractableEvaluatorTest {

    @Test
    public void testEvaluationSuccess() throws DetectableException {
        DetectorEvaluationOptions evaluationOptions = Mockito.mock(DetectorEvaluationOptions.class);
        ExtractionEnvironment extractionEnvironment = Mockito.mock(ExtractionEnvironment.class);
        Function<DetectorEvaluation, ExtractionEnvironment> extractionEnvironmentProvider = (detectorEvaluation) -> extractionEnvironment;

        ExtractableEvaluator evaluator = new ExtractableEvaluator(evaluationOptions, extractionEnvironmentProvider);
        DetectorEvaluationTree detectorEvaluationTree = Mockito.mock(DetectorEvaluationTree.class);
        Mockito.when(detectorEvaluationTree.getDirectory()).thenReturn(new File("."));

        DetectorEvaluation detectorEvaluation = Mockito.mock(DetectorEvaluation.class);

        Detectable detectable = Mockito.mock(Detectable.class);
        DetectableResult detectableExtractableResult = Mockito.mock(DetectableResult.class);
        Mockito.when(detectableExtractableResult.getPassed()).thenReturn(true);
        Mockito.when(detectableExtractableResult.toDescription()).thenReturn("test detectable");
        Mockito.when(detectable.extractable()).thenReturn(detectableExtractableResult);
        Mockito.when(detectorEvaluation.getDetectable()).thenReturn(detectable);
        List<DetectorEvaluation> detectorEvaluations = Collections.singletonList(detectorEvaluation);
        Mockito.when(detectorEvaluationTree.getOrderedEvaluations()).thenReturn(detectorEvaluations);

        DetectorRuleSet detectorRuleSet = Mockito.mock(DetectorRuleSet.class);
        Mockito.when(detectorEvaluationTree.getDetectorRuleSet()).thenReturn(detectorRuleSet);

        DetectorEvaluatorListener detectorEvaluatorListener = Mockito.mock(DetectorEvaluatorListener.class);
        evaluator.setDetectorEvaluatorListener(detectorEvaluatorListener);

        DetectorRule detectorRule = Mockito.mock(DetectorRule.class);
        Mockito.when(detectorRule.getDescriptiveName()).thenReturn("test rule");
        Mockito.when(detectorEvaluation.getDetectorRule()).thenReturn(detectorRule);
        Mockito.when(detectorRuleSet.getFallbackFrom(Mockito.any())).thenReturn(Optional.empty());

        Mockito.when(detectorEvaluationTree.getDepthFromRoot()).thenReturn(0);
        Mockito.when(evaluationOptions.isForceNested()).thenReturn(true);
        Predicate<DetectorRule> rulePredicate = it -> true;
        Mockito.when(evaluationOptions.getDetectorFilter()).thenReturn(rulePredicate);
        Mockito.when(detectorEvaluation.isSearchable()).thenReturn(true);
        Mockito.when(detectorEvaluation.isApplicable()).thenReturn(true);
        Mockito.when(detectorRule.createDetectable(Mockito.any(DetectableEnvironment.class))).thenReturn(detectable);
        Mockito.when(detectable.applicable()).thenReturn(new PassedDetectableResult());

        evaluator.evaluate(detectorEvaluationTree);

        Mockito.verify(detectorEvaluatorListener).extractableStarted(detectorEvaluation);
        Mockito.verify(detectorEvaluation).setExtractable(Mockito.any(DetectorResult.class));
        Mockito.verify(detectorEvaluatorListener).extractableEnded(detectorEvaluation);
    }

    @Test
    public void testEvaluationExtractableAlreadyPerformed() throws DetectableException {
        DetectorEvaluationOptions evaluationOptions = Mockito.mock(DetectorEvaluationOptions.class);
        ExtractionEnvironment extractionEnvironment = Mockito.mock(ExtractionEnvironment.class);
        Function<DetectorEvaluation, ExtractionEnvironment> extractionEnvironmentProvider = (detectorEvaluation) -> extractionEnvironment;

        ExtractableEvaluator evaluator = new ExtractableEvaluator(evaluationOptions, extractionEnvironmentProvider);
        DetectorEvaluationTree detectorEvaluationTree = Mockito.mock(DetectorEvaluationTree.class);
        Mockito.when(detectorEvaluationTree.getDirectory()).thenReturn(new File("."));

        DetectorEvaluation detectorEvaluation = Mockito.mock(DetectorEvaluation.class);

        Detectable detectable = Mockito.mock(Detectable.class);
        DetectableResult detectableExtractableResult = Mockito.mock(DetectableResult.class);
        Mockito.when(detectableExtractableResult.getPassed()).thenReturn(true);
        Mockito.when(detectableExtractableResult.toDescription()).thenReturn("test detectable");
        Mockito.when(detectable.extractable()).thenReturn(detectableExtractableResult);
        Mockito.when(detectorEvaluation.getDetectable()).thenReturn(detectable);
        List<DetectorEvaluation> detectorEvaluations = Collections.singletonList(detectorEvaluation);
        Mockito.when(detectorEvaluationTree.getOrderedEvaluations()).thenReturn(detectorEvaluations);

        DetectorRuleSet detectorRuleSet = Mockito.mock(DetectorRuleSet.class);
        Mockito.when(detectorEvaluationTree.getDetectorRuleSet()).thenReturn(detectorRuleSet);

        DetectorEvaluatorListener detectorEvaluatorListener = Mockito.mock(DetectorEvaluatorListener.class);
        evaluator.setDetectorEvaluatorListener(detectorEvaluatorListener);

        DetectorRule detectorRule = Mockito.mock(DetectorRule.class);
        Mockito.when(detectorRule.getDescriptiveName()).thenReturn("test rule");
        Mockito.when(detectorEvaluation.getDetectorRule()).thenReturn(detectorRule);
        Mockito.when(detectorRuleSet.getFallbackFrom(Mockito.any())).thenReturn(Optional.empty());

        Mockito.when(detectorEvaluationTree.getDepthFromRoot()).thenReturn(0);
        Mockito.when(evaluationOptions.isForceNested()).thenReturn(true);
        Predicate<DetectorRule> rulePredicate = it -> true;
        Mockito.when(evaluationOptions.getDetectorFilter()).thenReturn(rulePredicate);
        Mockito.when(detectorEvaluation.isSearchable()).thenReturn(true);
        Mockito.when(detectorEvaluation.isApplicable()).thenReturn(true);
        Mockito.when(detectorEvaluation.isExtractable()).thenReturn(true);
        Mockito.when(detectorRule.createDetectable(Mockito.any(DetectableEnvironment.class))).thenReturn(detectable);
        Mockito.when(detectable.applicable()).thenReturn(new PassedDetectableResult());

        evaluator.evaluate(detectorEvaluationTree);

        Mockito.verify(detectorEvaluatorListener).extractableStarted(detectorEvaluation);
        Mockito.verify(detectorEvaluation).setExtractable(Mockito.any(DetectorResult.class));
        Mockito.verify(detectorEvaluatorListener).extractableEnded(detectorEvaluation);
    }
}
