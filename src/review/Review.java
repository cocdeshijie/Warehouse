package review;

public class Review {
    private String reviewID;
    private int rating;
    private String comment;
    private String equipmentID;
    private String memberID;

    public Review(String reviewID, int rating, String comment, String equipmentID, String memberID) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.comment = comment;
        this.equipmentID = equipmentID;
        this.memberID = memberID;
    }

    // Getters and Setters
    public String getReviewID() { return reviewID; }
    public void setReviewID(String reviewID) { this.reviewID = reviewID; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }
}