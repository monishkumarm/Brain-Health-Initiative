START TRANSACTION;
Use BrainHealthInitiative;

-- (Common Questionnaire GroupId = 1)
SET @QuestionId =1;
SET @OptionId = 1;
SET @DiagnosisId =1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Loss of consciousness',
                                    1,
                                    1);

INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;

INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Sudden episode of loss of contact with the surroundings',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Uncontrollable shaking of head, arms or legs',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );


SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Abnormal speech',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Facial paralysis with sideways deviation of the mouth',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Weakness or Paralysis of arms or legs',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Difficulty in walking (exclude individuals with pain or swelling of joints of lower limbs)',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Any loss of sensation or any abnormal sensation in the face, arms and legs',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Deterioration of memory within the last five years (applicable to subjects above 30 years
                                    of age)',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Drooping of eyelids',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'temporary, for a few hours'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'permanent'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Episodes of severe facial pain',
                                    1,
                                    1);
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Headache',
                                    1,
                                 1);
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Unilateral'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Associated with flashes of light or circles'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Associated with vomiting'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Any recent change in behavior or personality',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Slowness of movement',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Tremor',
                                    1,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

-- Epilepsy Diagnosis Protocol GroupId = 2
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Did he/she pass urine or stool in his/her clothes during an episode',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Did he/she pass injure himself/herself or have tongue bite during an episode',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Was there frothing from mouth during an episode',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Did he/she pass have such an episode while asleep',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Was the patient completely unconsious during the episode',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Has an episode ever occured WITHOUT preceeding mental/emotional stress',
                                    2,
                                    1);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Events stereotypes and associated with aura',
                                    2,
                                    2);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Yes'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );

SET @QuestionId := @QuestionId +1;

-- Diagnosis: Generalized and focal seizure
INSERT INTO QuestionnaireDiagnosis VALUES(
                                             @DiagnosisId,
                                             'Probably generalized seizure'
                                         );

SET @DiagnosisId := @DiagnosisId+1;

INSERT INTO QuestionnaireDiagnosis VALUES(
                                             @DiagnosisId,
                                             'Probably focal seizure'
                                         );

-- Stroke Diagnostic Protocol GroupId = 3

COMMIT
