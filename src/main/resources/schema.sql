USE BrianHealthInitiative;

CREATE TABLE `User` (
                        `Id` BIGINT PRIMARY KEY,
                        `Username` VARCHAR(100) NOT NULL UNIQUE,
                        `FullName` VARCHAR(100) NOT NULL,
                        `RoleTypeId` INT NOT NULL,
                        `Email` VARCHAR(254) NOT NULL UNIQUE,
                        `PhoneNumber` VARCHAR(100) NOT NULL UNIQUE,
                        `TimeZoneId` INT NOT NULL,
                        `AddressDetail` JSON NOT NULL,
                        `Password` VARCHAR(100) NOT NULL,
                        `IsActive` BIT NOT NULL,
                        `CreatedOn` DATETIME NOT NULL,
                        `CreatedBy` BIGINT NOT NULL,
                        `LastChangeOn` DATETIME NOT NULL,
                        `LastChangeBy` BIGINT NOT NULL
);

CREATE TABLE `RoleType_lu` (
                               `Id` INT PRIMARY KEY,
                               `Name` VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE `Patient` (
                           `Id` BIGINT PRIMARY KEY,
                           `FullName` VARCHAR(100) NOT NULL,
                           `Gender` INT NOT NULL,
                           `Age` INT NOT NULL,
                           `Email` VARCHAR(100) NOT NULL UNIQUE,
                           `PhoneNumber` VARCHAR(100) NOT NULL UNIQUE,
                           `AddressDetail` JSON NOT NULL,
                           `Languages` VARCHAR(100),
                           `Education` VARCHAR(100),
                           `Occupation` VARCHAR(100),
                           `InformantCaregiverName` VARCHAR(100),
                           `RelationshipWithPatient` INT,
                           `CreatedOn` DATETIME NOT NULL,
                           `CreatedBy` BIGINT NOT NULL,
                           `LastChangeOn` DATETIME NOT NULL,
                           `LastChangeBy` BIGINT NOT NULL
);

CREATE TABLE `UserPermissionPatient` (
                                         `Id` BIGINT PRIMARY KEY,
                                         `PatientId` BIGINT NOT NULL,
                                         `UserId` BIGINT NOT NULL,
                                         `CanView` BIT NOT NULL,
                                         `CanModify` BIT NOT NULL,
                                         `CanDelete` BIT NOT NULL
);

CREATE UNIQUE INDEX UIX_UserPermissionPatient_PatientId_UserId ON UserPermissionPatient (PatientId, UserId);

CREATE TABLE `Organization` (
                                `Id` BIGINT PRIMARY KEY,
                                `Name` VARCHAR(100) NOT NULL UNIQUE,
                                `AddressDetail` JSON NOT NULL,
                                `IsActive` BIT NOT NULL
);

CREATE TABLE `UserOrganization` (
                                    `Id` BIGINT PRIMARY KEY,
                                    `UserId` BIGINT NOT NULL,
                                    `OrganizationId` BIGINT NOT NULL
);

CREATE TABLE `PatientConsultation` (
                                       `Id` BIGINT PRIMARY KEY,
                                       `PatientId` BIGINT NOT NULL,
                                       `DoctorId` BIGINT NOT NULL,
                                       `ReferredBy` BIGINT,
                                       `ReferredOn` DATETIME,
                                       `AppointmentTime` DATETIME NOT NULL,
                                       `ComplaintDetail` JSON NOT NULL,
                                       `DiagnosisTypeId` INT,
                                       `ICDDetail` JSON NOT NULL,
                                       `ImprovementStatusId` INT,
                                       `MedicineDetail` JSON NOT NULL,
                                       `TreatmentInstruction` VARCHAR(100) NOT NULL,
                                       `FollowUpDetail` JSON NOT NULL,
                                       `IsConsultationDone` BIT NOT NULL
);



CREATE TABLE `DiagnosisType_lu` (
                                    `Id` INT PRIMARY KEY,
                                    `Name` VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE `ImprovementStatus_lu` (
                                        `Id` INT PRIMARY KEY,
                                        `Name` VARCHAR(100) NOT NULL UNIQUE
);


ALTER TABLE `UserPermissionPatient` ADD CONSTRAINT FK_UserPermissionPatient_Patient FOREIGN KEY (`PatientId`) REFERENCES `Patient` (`Id`);

ALTER TABLE `UserPermissionPatient` ADD CONSTRAINT FK_UserPermissionPatient_User FOREIGN KEY (`UserId`) REFERENCES `User` (`Id`);


ALTER TABLE `User` ADD CONSTRAINT FK_User_User_CreatedBy FOREIGN KEY (`CreatedBy`) REFERENCES `User` (`Id`);

ALTER TABLE `User` ADD CONSTRAINT FK_User_User_LastChangeBy FOREIGN KEY (`LastChangeBy`) REFERENCES `User` (`Id`);

ALTER TABLE `User` ADD CONSTRAINT FK_User_RoleType_lu FOREIGN KEY (`RoleTypeId`) REFERENCES `RoleType_lu` (`Id`);

ALTER TABLE `Patient` ADD CONSTRAINT FK_Patient_User_CreatedBy FOREIGN KEY (`CreatedBy`) REFERENCES `User` (`Id`);

ALTER TABLE `Patient` ADD CONSTRAINT FK_Patient_User_LastChangeBy FOREIGN KEY (`LastChangeBy`) REFERENCES `User` (`Id`);

ALTER TABLE `UserOrganization` ADD CONSTRAINT FK_UserOrganization_User FOREIGN KEY (`UserId`) REFERENCES `User` (`Id`);

ALTER TABLE `UserOrganization` ADD CONSTRAINT FK_UserOrganization_Organization FOREIGN KEY (`OrganizationId`) REFERENCES `Organization` (`Id`);


ALTER TABLE `PatientConsultation` ADD CONSTRAINT FK_PatientConsultation_Patient FOREIGN KEY (`PatientId`) REFERENCES `Patient` (`Id`);

ALTER TABLE `PatientConsultation` ADD CONSTRAINT FK_PatientConsultation_User_DoctorId FOREIGN KEY (`DoctorId`) REFERENCES `User` (`Id`);

ALTER TABLE `PatientConsultation` ADD CONSTRAINT FK_PatientConsultation_User_ReferredBy FOREIGN KEY (`ReferredBy`) REFERENCES `User` (`Id`);

ALTER TABLE `PatientConsultation` ADD CONSTRAINT FK_PatientConsultation_DiagnosticType_lu FOREIGN KEY (`DiagnosisTypeId`) REFERENCES `DiagnosisType_lu` (`Id`);

ALTER TABLE `PatientConsultation` ADD CONSTRAINT FK_PatientConsultation_ImprovementStatus_lu FOREIGN KEY (`ImprovementStatusId`) REFERENCES `ImprovementStatus_lu` (`Id`);





