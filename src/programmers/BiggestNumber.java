package programmers;

class BiggestNumber {
    public String solution(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
        }
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == '0') {
                stringBuilder.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        for (int i = left; i < right; i++) {
            if (compare(array[i], array[right])) {
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

    public boolean compare(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        return Integer.parseInt(strA + strB) > Integer.parseInt(strB + strA);
    }
}
