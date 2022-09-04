package com.epam.rd.contactbook;

public class Contact {

    private final ContactInfo[] contactInfo = new ContactInfo[10];

    private String value;

    private int e = 2;
    private int s = 5;

    /**
     * NameContactInfo
     */

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public Contact(String contactName) {
        value = contactName;
        contactInfo[0] = new NameContactInfo();
    }

    public void rename(String newName) {
        if (newName != null && !newName.equals("")) {
            value = newName;
            contactInfo[0] = new NameContactInfo();
        }
    }

    /**
     * Email
     */

    public static class Email implements ContactInfo {
        String title;
        String value;

        public Email() {

        }

        public Email(String title1, String value1) {
            title = title1;
            value = value1;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public Email addEmail(String localPart, String domain) {
        Email mail = new Email("Email", localPart + "@" + domain);

        if (e > 4) return null;
        contactInfo[e] = mail;
        e++;

        return mail;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        Email epam = new Email() {
            @Override
            public String getTitle() {
                return "Epam Email";
            }

            @Override
            public String getValue() {
                return firstname + "_" + lastname + "@epam.com";
            }
        };

        if (e > 4) return null;
        contactInfo[e] = epam;
        e++;

        return epam;
    }

    /**
     * addPhoneNumber
     */

    public ContactInfo addPhoneNumber(int code, String number) {
        if (contactInfo[1] != null) return null;

        ContactInfo result = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        contactInfo[1] = result;
        return result;
    }

    /**
     * Social
     */

    public static class Social implements ContactInfo {
        @Override
        public String getTitle() {
            return "title";
        }

        @Override
        public String getValue() {
            return "value";
        }
    }

    public Social addTwitter(String twitterId) {
        Social social = new Social() {
            @Override
            public String getTitle() {
                return "Twitter";
            }

            @Override
            public String getValue() {
                return twitterId;
            }
        };

        if (s > 9) return null;
        contactInfo[s] = social;
        s++;

        return social;
    }

    public Social addInstagram(String instagramId) {
        Social social = new Social() {
            @Override
            public String getTitle() {
                return "Instagram";
            }

            @Override
            public String getValue() {
                return instagramId;
            }
        };

        if (s > 9) return null;
        contactInfo[s] = social;
        s++;

        return social;
    }

    public Social addSocialMedia(String titleMedia, String id) {
        Social social = new Social() {
            @Override
            public String getTitle() {
                return titleMedia;
            }

            @Override
            public String getValue() {
                return id;
            }
        };

        if (s > 9) return null;
        contactInfo[s] = social;
        s++;

        return social;
    }

    /**
     * GetInfo
     */

    public ContactInfo[] getInfo() {
        System.out.println("Old size arr: " + contactInfo.length);

        for (ContactInfo item : contactInfo) {
            if (item != null) {
                System.out.println("Title: " + item.getTitle() + " \t\t Value: " + item.getValue());
            } else {
                System.out.println("null");
            }
        }

        int k = 0;
        int size = 0;

        for (ContactInfo item : contactInfo) {
            if (item != null) size++;
        }
        System.out.println("New Size: " + size);

        ContactInfo[] newContactInfo = new ContactInfo[size];

        for (ContactInfo item : contactInfo) {
            if (item != null) {
                newContactInfo[k] = item;
                k++;
            }
        }

        for (ContactInfo item : newContactInfo) {
            System.out.println("Title: " + item.getTitle() + " \t\t Value: " + item.getValue());
        }

        return newContactInfo;
    }


}
