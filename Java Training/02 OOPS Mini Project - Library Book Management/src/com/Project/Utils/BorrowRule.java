package com.Project.Utils;

import com.Project.Member.Member;

@FunctionalInterface
public interface BorrowRule {

	boolean canBorrow(Member member);

//	BorrowRule rule = booksBorrowed -> booksBorrowed <= 5;
}
