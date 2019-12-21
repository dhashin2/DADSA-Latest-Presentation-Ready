package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class MemberNode { //Creating Node which only works with member instances
    //Fields
    private Member member;
    private MemberNode nextMember;
    
    public MemberNode (Member member){ //Constructor
        this.member = member;
    }
    //Getters and setters for member and nextmember
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberNode getNextMember() {
        return nextMember;
    }

    public void setNextMember(MemberNode nextMember) {
        this.nextMember = nextMember;
    }
    
    public void printMember(){ //Print Member list
        int mNumber = this.member.getMemberID();
        String mName = this.member.getMemberName();
        String username = this.member.getUsername();
        //int password = this.member.getPassword(); //If you want to view passwords through console just uncomment this and the things i sout
        
        System.out.println("Member ID: " + mNumber + "| Member Name: " + mName + "| Username: " + username/* + "| Password: " + password */);
    }
    
}
