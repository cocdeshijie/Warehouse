package review;

public class Review {
    private String reviewID;
    private String memberID;
    private int rating;
    private String comment;

    public Review(String reviewID, String memberID, int rating, String comment) {
        this.reviewID = reviewID;
        this.memberID = memberID;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters
    public String getReviewID() { return reviewID; }
    public void setReviewID(String reviewID) { this.reviewID = reviewID; }

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
