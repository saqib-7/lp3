// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    struct Student {
        uint roll;
        string name;
        uint marks;
    }

    Student[] public students;
    uint public fallbackCalls;

    function addStudent(uint roll, string memory name, uint marks) public {
        students.push(Student(roll, name, marks));
    }

    function getStudent(uint index) public view returns (uint, string memory, uint) {
        Student memory s = students[index];
        return (s.roll, s.name, s.marks);
    }

    function totalStudents() public view returns (uint) {
        return students.length;
    }

    fallback() external payable {
        fallbackCalls++;
    }

    receive() external payable { }
}
