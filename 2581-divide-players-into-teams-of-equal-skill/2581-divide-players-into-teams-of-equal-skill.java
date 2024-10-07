class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        
        int i = 0;
        int j = skill.length-1;
        int lastTeam = skill[i] + skill[j];
        long chemistry = (skill[i] * skill[j]);
        i++;
        j--;

        while (i < j) {
            if (lastTeam != skill[i] + skill[j]) {
                return -1;
            }
            chemistry += (skill[i] * skill[j]);
            i++;
            j--;
        }

        return chemistry;
    }
}