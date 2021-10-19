package programmers;

class N번째_수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int left = commands[i][0] - 1;
            int right = commands[i][1] - 1;
            int idx = commands[i][2] - 1;

            int[] temp = new int[right - left + 1];
            for (int j = 0; j < right - left + 1; j++) {
                temp[j] = array[left + j];
            }
            quickSort(temp, 0, right - left);
            answer[i] = temp[idx];
        }
        return answer;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                int temp = array[i];
                array[i] = array[l];
                array[l] = temp;
                l++;
            }
        }
        int temp = array[l];
        array[l] = array[right];
        array[right] = temp;

        quickSort(array, left, l - 1);
        quickSort(array, l + 1, right);
    }
}
