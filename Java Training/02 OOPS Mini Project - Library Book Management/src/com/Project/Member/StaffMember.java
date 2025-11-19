package com.Project.Member;

public class StaffMember extends Member {
	public StaffMember(String memberId, String name) {
		super(memberId, name);
	}

	@Override
	public int getMaxBooksAllowed() {
		return 5;
	}
}