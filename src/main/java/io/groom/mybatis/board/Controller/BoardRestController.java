package io.groom.mybatis.board.Controller;

import io.groom.mybatis.board.model.Board;
import io.groom.mybatis.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardRestController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public String index() {
        return "api index";
    }

    @GetMapping("/boards")
    public List<Board> list() {
        List<Board> list = boardService.getBoards();
        log.debug("list size : " + list.size());
        log.debug("test ");
        return list;
    }

    @GetMapping("/boards/{seq}")
    public Board get(@PathVariable Long seq) {
        log.debug("seq : " + seq);
        return boardService.getBoardById(seq);
    }

    @PostMapping("/boards")
    public int create(@RequestBody Board board) {
        log.debug("board : " + board);
        return boardService.createBoard(board);
    }
}
