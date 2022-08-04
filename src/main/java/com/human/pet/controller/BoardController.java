package com.human.pet.controller;

//외장 라이브러리 호출(import), gradle로 설치한 라이브러리
import com.human.pet.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//내장 라이브러리 호출(import)
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

//    @RequestMapping은 서버에서 디스페처서블릿을 통해 html의 action태그의 주소와 동일한
//    문자열을 찾는 매핑기능(연결)이 실행되고 하단에 메서드가 실행
//    return String인 이유는 뷰리졸버가 html파일을 찾기 위한 문자열 리턴

    //클라이언트에서 서버로 무언가 데이터를 전송하기 위한 Mapping(@RequestMapping)
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model){
        //List 타입으로 Board객체를 넣는 boardList변수명 선언
        // = (대입연사자)로 heap메모리에 ArrayList타입으로 할당
        //List는 ArrayList의 부모클래스
        List<Board> boardList = new ArrayList<Board>();
        
        for(int i =1; i<=10; i++) {
            //Board 클래스로 board인스턴스 생성
            Board board = new Board();
            //롬북으로 자동생성된 seter 메서드로 데이터 입력
            board.setSeq(new Long(i));
            board.setTitle("게시판 프로그램 테스트"+i);
            board.setWriter("도우너");
            board.setContent("게시판 프로그램 테스트입니다.");
            //내장 클래스인 java.util.Date 객체로 시간 데이터 출력
            board.setCreateDate(new Date());
            board.setCnt(0L);
            //boardList배열에 board객체 넣기(for문 10번 도니까 board객체 10개 넣기)
            boardList.add(board);
        }
        //model 객체에 boardList(arrayList)를 boardList key값으로 넣음
        //attributeName = key
        //attributeValue = value
        //model에는 참조타입만 넣을 수 있다(addAttribute 메서드 안에 매개변수 타입으로 확인 가능)
        model.addAttribute("boardList", boardList);
        System.out.println("출력");
        //디서패처서블릿이 뷰 리졸버를 찾아서 연결해 줍니다.
        //viewResolver
        //return getBoardList라는 문자열로 templates에 있는 같은 이름에 html파일을 찾는다.
        return "getBoardList";
        }
        @GetMapping("/insertBoard")
        public String insertBoardView(){
            return "insertBoard";
        }
        @GetMapping("/getBoard")
        public String getBoard(Board board, Model model){
            model.addAttribute("board"/*, boardService.getBoard(board)*/);
            return "getBoard";
        }
        @PostMapping("updateBoard")
    public String updateBoard(Board board){
        /*boardService.updateBoard(board);*/
        return "foward:getBoardList";
        }



//        @PostMapping("/insertBoard")
//        public String insertBoard(Board board){
//            boardService.insertBoard(board);
//            return "redirect:getBoardList";
//        }
    }
