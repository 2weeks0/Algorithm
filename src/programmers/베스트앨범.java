package programmers;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {


    }
    class Solution {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Song[] songs = null;

        public int[] solution(String[] genres, int[] plays) {
            init(genres, plays);
            quickSort(songs, 0, genres.length - 1);
            return getAnswer();
        }

        public void init(String[] genres, int[] plays) {
            songs = new Song[genres.length];
            for (int i = 0; i < genres.length; i++) {
                songs[i] = new Song(genres[i], plays[i], i);
                if (hashMap.containsKey(genres[i])) {
                    hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
                } else {
                    hashMap.put(genres[i], plays[i]);
                }
            }
        }

        public void quickSort(Song[] songs, int left, int right) {
            if (left >= right) {
                return;
            }

            int l = left;
            for (int i = left; i < right; i++) {
                if (songs[i].compare(songs[right])) {
                    Song temp = songs[i];
                    songs[i] = songs[l];
                    songs[l] = temp;
                    l++;
                }
            }
            Song temp = songs[l];
            songs[l] = songs[right];
            songs[right] = temp;
            quickSort(songs, left, l - 1);
            quickSort(songs, l + 1, right);
        }

        public int[] getAnswer() {
            hashMap.clear();
            List<Integer> result = new ArrayList<>();
            for (Song song: songs) {
                if (hashMap.containsKey(song.genre)) {
                    hashMap.put(song.genre, hashMap.get(song.genre) + 1);
                } else {
                    hashMap.put(song.genre, 1);
                }

                if (hashMap.get(song.genre) < 3) {
                    result.add(song.index);
                }
            }

            return result.stream().mapToInt(i -> i).toArray();
        }

        class Song {
            String genre;
            int plays;
            int index;

            public Song(String genre, int plays, int index) {
                this.genre = genre;
                this.plays = plays;
                this.index = index;
            }

            public boolean compare(Song other) {
                if (genre.equals(other.genre)) {
                    if (Objects.equals(plays, other.plays)) {
                        return index < other.index;
                    }
                    return plays > other.plays;
                }
                return hashMap.get(genre) > hashMap.get(other.genre);
            }
        }
    }
}
