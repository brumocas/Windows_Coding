package com.braching;

        public class WeekdaySwitchCase {
            public String getDayOfWeek(String dayOfWeek) {
                switch (dayOfWeek.toLowerCase()) {
                    case "monday":
                        return "It's Monday.";
                    case "tuesday":
                        return "It's Tuesday.";
                    case "wednesday":
                        return "It's Wednesday.";
                    case "thursday":
                        return "It's Thursday.";
                    case "friday":
                        return "It's Friday.";
                    case "saturday":
                        return "It's Saturday.";
                    case "sunday":
                        return "It's Sunday.";
                    default:
                        throw new IllegalArgumentException("Invalid day of the week.");
                }
            }
        }
