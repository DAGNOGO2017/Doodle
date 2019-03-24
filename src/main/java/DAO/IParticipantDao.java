package DAO;

import java.util.List;

import Entities.Participant;

public interface IParticipantDao {
	public Participant addParticipant(Participant participant);
	public void removeParticipant(Participant participant);
	public void updateParticipant(Participant participant);
	public List<Participant> getList();
	public Participant getParticipantBId(String id);
}
