public class NumberParser {
    String[] numbers = {"いち", "に", "さん", "よん", "ご", "ろく", "なな", "はち", "きゅう"};
    String parseNumber(String n){
        //System.out.println(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n.length(); i++){
            stringBuilder.append(parseDigit(n.length() - i, n.substring(i, i+1)));
        }
        return stringBuilder.toString();
    }
    String parseDigit(int digitNum, String digit){

        switch (digitNum){
            case 5:
                if (Integer.parseInt(digit) == 0){
                    return "";
                } else{
                    return numbers[Integer.parseInt(digit) -1] + "まん";
                }

            case 4:
                if (Integer.parseInt(digit) == 0){
                    return "";
                } else if (Integer.parseInt(digit) == 1){
                    return "せん";
                }  else if (Integer.parseInt(digit) == 3){
                    return "さんぜん";
                } else if (Integer.parseInt(digit) == 8){
                    return "はっせん";
                } else {
                    return numbers[Integer.parseInt(digit) -1] + "せん";
                }

            case 3:
                if (Integer.parseInt(digit) == 0){
                    return "";
                }
                else if (Integer.parseInt(digit) == 1){
                    return "ひゃく";
                } else if(Integer.parseInt(digit) == 3){
                    return "さんびゃく";
                } else if(Integer.parseInt(digit) == 6){
                    return "ろっぴゃく";
                } else if (Integer.parseInt(digit) == 8){
                    return "はっぴゃく";
                } else {
                    return numbers[Integer.parseInt(digit) -1] + "ひゃく";
                }

            case 2:
                if (Integer.parseInt(digit) == 0){
                    return "";
                } else{
                    if (Integer.parseInt(digit) == 1){
                        return "じゅう";
                    } else{
                        return numbers[Integer.parseInt(digit) -1] + "じゅう";
                    }
                }

            case 1:
                if (Integer.parseInt(digit) == 0){
                    return "";
                } else{
                    return numbers[Integer.parseInt(digit) - 1];
                }

        }
        return "";
    }
}
