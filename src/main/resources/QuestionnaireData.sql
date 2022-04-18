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

-- subgroup - 1 - starts
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

-- subgroup -1- end

-- subgroup -2- start

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'patient is below 10 years old',
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

-- subgroup -2- end


-- subgroup -3- start


INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Unprovoked stereotyped motor or sensory events',
                                    2,
                                    3);

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
                                    'Involvingnonly one part of the body',
                                    2,
                                    3);

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
                                    'Impaired awareness of surroundings',
                                    2,
                                    3);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'With'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Without'
                                      );
SET @QuestionId := @QuestionId +1;


-- subgroup -3- end

-- subgroup -4- start


INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'A diagnosis of epilepsy is made when a patient has more than 1 unproveked seizure 24 hours apart',
                                    2,
                                    4);

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

-- subgroup -4- end

-- subgroup -5- start

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Is he/she have fever',
                                    2,
                                    5);

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

-- subgroup -5- end

-- subgroup -6- start
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Brief events (<few secs)',
                                    2,
                                    6);

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
                                    'Blinking/staring',
                                    2,
                                    6);

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
                                    'Multiple per day',
                                    2,
                                    6);

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
                                    'Precipitated at bedside by hyperventilation',
                                    2,
                                    6);

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
                                    'No developmental delay/regression',
                                    2,
                                    6);

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
                                    'Onset after 3 years',
                                    2,
                                    6);

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


-- subgroup -6 - end

-- subgroup -7- start
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Generalized convulsive',
                                    2,
                                    7);

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
                                    'Single episode',
                                    2,
                                    7);

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
                                    'Lasts <5 minutes',
                                    2,
                                    7);

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
                                    'No post ictal weakness',
                                    2,
                                    7);

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
                                    'No developmental delay/regression',
                                    2,
                                    7);

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
                                    'Regains consciouness completely within 5 min',
                                    2,
                                    7);

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
                                    'Is he/she below 5 year',
                                    2,
                                    7);

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

-- subgroup -7 - end--

-- Stroke Diagnostic Protocol GroupId = 3

-- SUBGROUP 1 STARTS --

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Abnormal speech',
                                    3,
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
                                    3,
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
                                    'Weakness or paralysis of arms and/or legs',
                                    3,
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
                                    'Difficulty in walking (exclude individuals with pain or swelling of
                                    joints of lower
                                    limbs)',
                                    3,
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
                                    'Any loss of sensation or any abnormal sensation in the face, arms
                                    and legs',
                                    3,
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

-- SUBGROUP 1 ENDS --

-- SUBGROUP 2 STARTS --

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Weakness or loss of sensation on one side of body with deviation of
                                    face to one side',
                                    3,
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
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Impaired consciousness',
                                    3,
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
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Speech difficulty',
                                    3,
                                    2);

SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'No'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Slurred speech'
                                      );
SET @OptionId := @OptionId +1;
INSERT INTO QuestionnaireOption VALUES(
                                          @OptionId,
                                          @QuestionId,
                                          'Difficulty in speaking or understanding'
                                      );

SET @QuestionId := @QuestionId +1;
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Loss of balance or incoordination while walking',
                                    3,
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
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Dizziness',
                                    3,
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

INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Swallowing problems',
                                    3,
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
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    ' Double vision',
                                    3,
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
INSERT INTO Questionnaire VALUES(
                                    @QuestionId,
                                    'Vision impairment',
                                    3,
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

-- SUBGROUP 2 Ends --

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



COMMIT