package a4if1.insa.com.oboolo;

import javax.security.auth.Subject;

public class SubjectData {

    private int affinityLevel;
    private int workLevel;
    private boolean targetedScore;
    private int desiredScore;

    public SubjectData(int affinityLevel, int workLevel, boolean hasTargetedScore, int desiredScore){
        this.affinityLevel=affinityLevel;
        this.workLevel=workLevel;
        this.targetedScore=hasTargetedScore;
        this.desiredScore=desiredScore;
    }

    public SubjectData(int affinityLevel, int workLevel){
        this(affinityLevel, workLevel, false, 10);
    }
    public SubjectData(){
        this(0,0,false,10);
    }

    public int getAffinityLevel() {
        return affinityLevel;
    }

    public int getWorkLevel() {
        return workLevel;
    }

    public boolean hasTargetedScore() {
        return targetedScore;
    }

    public int getDesiredScore() {
        return desiredScore;
    }

    public void setAffinityLevel(int affinityLevel) {
        this.affinityLevel = affinityLevel;
    }

    public void setWorkLevel(int workLevel) {
        this.workLevel = workLevel;
    }

    public void setTargetedScore(boolean hasTargetedScore) {
        this.targetedScore = hasTargetedScore;
    }

    public void setDesiredScore(int desiredScore) {
        this.desiredScore = desiredScore;
    }
}
