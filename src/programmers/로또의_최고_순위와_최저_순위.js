function solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];
    let cntZero = 0;
    let cntEqual = 0;
    for (num of lottos) {
        if (win_nums.includes(num)) {
            cntEqual++;
        } else if (num === 0) {
            cntZero++;
        }
    }

    return [rank[cntEqual + cntZero], rank[cntEqual]];
}
