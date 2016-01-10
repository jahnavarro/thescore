package thescore.repository;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import thescore.model.Comment;
import thescore.model.ForumFilter;
import thescore.model.Topic;

@Repository
public class ForumRepository extends AbstractRepository<Integer, Topic> {

	public Topic findTopicById(int id) {
		return getByKey(id);
	}
	
	public Comment findCommentById(int id) {
		return (Comment) getSession().get(Comment.class, id);
	}

	public void saveTopic(Topic topic) {
		persist(topic);
	}
	
	public void saveComment(Comment comment) {
		getSession().persist(comment);
	}

	public void deleteRecordById(Integer id) {
		deleteRecordById(Topic.ENTITY_NAME, id);
	}

	@SuppressWarnings("unchecked")
	public List<Topic> findAllTopics() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.desc("date"));
		return (List<Topic>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> findAllComments(Integer topicId) {
		Criteria criteria = getSession().createCriteria(Comment.class);
		criteria.add(Restrictions.eq("topic.id", topicId));
		criteria.addOrder(Order.asc("date"));
		return (List<Comment>) criteria.list();
	}
	
	public ForumFilter findDefaultForumFilter(){
		return (ForumFilter) getSession()
				.createCriteria(ForumFilter.class)
				.addOrder(Order.asc("id"))
				.setMaxResults(1)
				.uniqueResult();
	}
	
	public Boolean isCommentValueValid(String value){
		ForumFilter filter = findDefaultForumFilter();
		
		List<String> invalidWords = Arrays.asList(filter.getValue().split(","));
		
		System.out.println(invalidWords);
		
		for(String invalidWord : invalidWords){
			if(value.contains(invalidWord.trim())){
				return false;
			}
		}
		return true;
	}
	
}
