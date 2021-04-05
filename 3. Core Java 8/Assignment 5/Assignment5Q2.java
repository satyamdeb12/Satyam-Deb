package Assignment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;

class News {
    private int newsId;
    private String postedByUser;
    private String commentByUser;
    private String comment;
	public News(int newsId, String postedByUser, String commentByUser, String comment) {
		super();
		this.newsId = newsId;
		this.postedByUser = postedByUser;
		this.commentByUser = commentByUser;
		this.comment = comment;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getPostedByUser() {
		return postedByUser;
	}
	public void setPostedByUser(String postedByUser) {
		this.postedByUser = postedByUser;
	}
	public String getCommentByUser() {
		return commentByUser;
	}
	public void setCommentByUser(String commentByUser) {
		this.commentByUser = commentByUser;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
}

public class Assignment5Q2 {
	/*
	 * 1. Find out the newsId which has received maximum comments.
	 */
    public static int maxComments(List<News> news) {
    	
    	HashMap<Integer,Integer> m = (HashMap<Integer, Integer>) news.
                stream().
                collect(Collectors.groupingBy(News::getNewsId,Collectors.summingInt(a->1)));

        int max = 0;
        int maxKey = 0;

        for(Map.Entry map:m.entrySet()){
            if(max<(int) map.getValue()){
                max = (int) map.getValue();
                maxKey = (int) map.getKey();
            }
        }
        return maxKey;
    }

    /*
     * 2. Find out how many times the word 'budget' arrived in user comments all news.
     */
    public static int budgetCount (List < News > news) {
    	return (int)news.stream().filter(x-> x.getComment().contains("budget"))
                .count();
    }
    
    /*
     * 3. Find out which user has posted maximum comments.
     */
    public static String maxCommentsByUser (List < News > news) {
    	
    	HashMap<String,Integer> m = (HashMap<String, Integer>) news.
                stream().
                collect(Collectors.groupingBy(News::getCommentByUser,Collectors.summingInt(a->1)));

        String user = null;
        int max = 0;

        for(Map.Entry map:m.entrySet()){
            if(max< (int) map.getValue()){
                max = (int) map.getValue();
                user = (String) map.getKey();
            }
        }
        
    	return user;
    }

    
    /*
     * 4. Display commentByUser wise number of comments.
     */
    public static Map<String, Integer> sortMaxCommentsByUser (List < News > news) {
    	Map<String,Integer> m = news.
                stream().
                collect(Collectors.groupingBy(News::getCommentByUser,Collectors.summingInt(a->1)));

         Map<String, Integer> s =  m.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
         return s;
    }

    public static void main(String[] args) {
    	News n1 = new News(101,"Ravish Kumar","Commenter1","comment");
    	News n2 = new News(101,"Ravish Kumar","Commenter2","budget");
    	News n3 = new News(101,"Ravish Kumar","Commenter3","comment");
    	News n4 = new News(102,"Preeti Kaur","Commenter1","budget");
    	News n5 = new News(102,"Preeti Kaur","Commenter2","comment");
    	News n6 = new News(103,"Neelum Sharma","Commenter1","comment");
    	List<News> news = new ArrayList<News>();
    	news.add(n1);
    	news.add(n2);
    	news.add(n3);
    	news.add(n4);
    	news.add(n5);
    	news.add(n6);
    	
    	
    	//------------------Testing maxComments Method---------------
    	System.out.println(maxComments(news));
    	//------------------Testing budgetCount Method---------------
    	System.out.println(budgetCount(news));
    	//------------------Testing maxCommentsByUser Method---------
    	System.out.println(maxCommentsByUser(news));
    	//------------------Testing sortMaxCommentsByUser Method-----
    	System.out.println(sortMaxCommentsByUser(news));
    	
    }
}
