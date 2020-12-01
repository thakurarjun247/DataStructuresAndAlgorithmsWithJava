package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DomainName {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String[] a = {"codinginterview", "coding"/*, "tech", "techinterview", "interview"*/};
        String[] b = {"edgemakers"};
        String addOns[] = {"bootcamp", "academy", "school", "point", "corner", "edgemakers"};

        String extensions[] = {".com"
                , ".tech", ".academy", ".university",
                ".institute",
                ".academy",
                ".study",
                ".school",
                ".education",
                ".college",
                ".courses",


                ".shiksha",
                ".edu",
                ".academy",
                ".coach",
                ".careers",
                ".center",
                ".training",
                ".camp",
                ".institute",
                ".tech",
                ".study",
                ".school",
                ".college",
                ".institute",
                ".university",
                ".training",
                ".coach"
        };

        for (int e = 0; e < 1;e++){
            String ext=extensions[e];
            {
                Arrays.asList(a).forEach(item -> builder.append(item+ext).append(", "));
                Arrays.asList(b).forEach(item -> builder.append(item+ext).append(", "));
                Arrays.asList(a).forEach(item -> {
                    for(int i=1;i< extensions.length;i++)
                    {
                        builder.append(item+extensions[i].substring(1)+".com , ");
                    }
                });

                Arrays.asList(a).forEach(item -> {
                    for(int x=0;x<addOns.length;x++)
                    builder.append(item+addOns[x]+ext).append(", ");
                });
                builder.append("\n");
            }
        }
        System.out.println(builder.toString());
    }

}

//interview.academy, interview-.school, codinginterviewschool.com, codinginterview.school