class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String person : details) {
            int age = 0;
            age += (person.charAt(11) - '0');
            age *= 10;
            age += (person.charAt(12) - '0');

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}