package edu.geekhub.utils;

import edu.geekhub.models.User;
import edu.geekhub.models.request.Request;

import java.security.SecureRandom;
import java.util.UUID;

import static edu.geekhub.utils.RandomUtils.getRandomElement;
import static edu.geekhub.utils.RandomUtils.getRandomString;

public class RandomRequestDataGenerator implements RequestDataGenerator {

    private static final String[] VALID_DOMAINS = new String[]{"test.stub", "test-stub.bar", "foo.bar"};
    private static final String[] INVALID_DOMAINS = new String[]{"test,stub", "\"test.stub\"", "test .stub", "tes`t.stub",
            "test$bar", " foo.bar", " foo bar ", "'foo.bar'", "@@foo.bar"};
    private static final String[] NAMES = new String[]{"James", "John", "Emily", "Token", "Butters", "Cartman", "Bond"};

    private final SecureRandom random = new SecureRandom();

    @Override
    public Request generate() {
        Object requestData = generateRequestData();

        return new Request(requestData);
    }

    private Object generateRequestData() {
        boolean userData = random.nextBoolean();
        if (userData) {
            return generateUserData();
        }

        boolean stringData = random.nextBoolean();
        if (stringData) {
            return "";
        }

        return null;
    }

    private User generateUserData() {
        return User.toBuilder()
                .withId(getRandomId())
                .withEmail(getRandomEmail())
                .withUserName(getRandomUsername())
                .withFullName(getRandomFullName())
                .withAge(getRandomAge())
                .withNotes(getRandomNotes())
                .withAmountOfFollowers(getRandomAmountOfFollowers())
                .build();
    }

    private UUID getRandomId() {
        boolean validUUID = random.nextBoolean();
        if (validUUID) {
            return UUID.randomUUID();
        }

        boolean duplicatedUUID = random.nextBoolean();
        if (duplicatedUUID) {
            return UUID.nameUUIDFromBytes("DUPLICATED ID".getBytes());
        }

        return null;
    }

    private String getRandomEmail() {
        boolean randomEmail = random.nextBoolean();
        if (randomEmail) {
            return generateRandomEmail();
        }

        boolean duplicatedEmail = random.nextBoolean();
        if (duplicatedEmail) {
            return "duplicated.email@test.stub";
        }

        boolean emptyEmail = random.nextBoolean();
        if (emptyEmail) {
            boolean includeSpace = random.nextBoolean();
            return includeSpace ? " " : "";
        }
        return null;
    }

    private String generateRandomEmail() {
        StringBuilder emailBuilder = new StringBuilder();

        boolean hasFirstPartOfEmail = random.nextBoolean();
        if (hasFirstPartOfEmail) {
            emailBuilder.append(getRandomString(10));
        }

        boolean hasAtSymbol = random.nextBoolean();
        if (hasAtSymbol) {
            emailBuilder.append("@");
        }

        boolean hasDomain = random.nextBoolean();
        if (hasDomain) {
            boolean validDomain = random.nextBoolean();
            if (validDomain) {
                String domain = getRandomElement(VALID_DOMAINS);
                emailBuilder.append(domain);
            } else {
                String domain = getRandomElement(INVALID_DOMAINS);
                emailBuilder.append(domain);
            }
        }

        return emailBuilder.toString();
    }

    private String getRandomUsername() {
        boolean randomUsername = random.nextBoolean();
        if (randomUsername) {
            return getRandomString(random.nextInt(0, 30));
        }

        boolean duplicatedUsername = random.nextBoolean();
        if (duplicatedUsername) {
            return "duplicatedUsername";
        }

        boolean emptyUsername = random.nextBoolean();
        if (emptyUsername) {
            boolean includeSpace = random.nextBoolean();
            return includeSpace ? " " : "";
        }

        return null;
    }

    private String getRandomFullName() {
        boolean randomFullName = random.nextBoolean();
        if (randomFullName) {
            return generateRandomFullName();
        }

        boolean emptyFullName = random.nextBoolean();
        if (emptyFullName) {
            boolean includeSpace = random.nextBoolean();
            return includeSpace ? " " : "";
        }

        return null;
    }

    private String generateRandomFullName() {
        StringBuilder fullNameBuilder = new StringBuilder();

        boolean hasFirstName = random.nextBoolean();
        if (hasFirstName) {
            String firstName = getRandomElement(NAMES);
            fullNameBuilder.append(firstName);
        }

        boolean hasSpaceBetween = random.nextBoolean();
        if (hasSpaceBetween) {
            fullNameBuilder.append(" ");
        }

        boolean hasLastName = random.nextBoolean();
        if (hasLastName) {
            String lastName = getRandomElement(NAMES);
            fullNameBuilder.append(lastName);
        }

        String fullName = fullNameBuilder.toString();

        boolean inLowerCase = random.nextBoolean();
        if (inLowerCase) {
            fullName = fullName.toLowerCase();
        }

        boolean inUpperCase = random.nextBoolean();
        if (inUpperCase) {
            fullName = fullName.toUpperCase();
        }

        return fullName;
    }


    private Integer getRandomAge() {
        if (random.nextBoolean()) {
            return random.nextInt(-100, 1000);
        } else {
            return null;
        }
    }

    private String getRandomNotes() {
        boolean hasNotes = random.nextBoolean();
        if (hasNotes) {
            return getRandomString(100);
        }

        boolean notesEmpty = random.nextBoolean();
        if (notesEmpty) {
            boolean includeSpace = random.nextBoolean();
            return includeSpace ? " " : "";
        }

        return null;
    }

    private Long getRandomAmountOfFollowers() {
        if (random.nextBoolean()) {
            return random.nextLong(-100, 10000000);
        } else {
            return null;
        }
    }
}
