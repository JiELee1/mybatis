package io.groom.mybatis.board.Controller;

import io.groom.mybatis.board.model.Board;
import io.groom.mybatis.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public String index() {
        return "board/index";
    }

    @GetMapping("/boards")
    public String list(Model model) {
        model.addAttribute("posts",boardService.getBoards());
        return "board/list";
    }

    @GetMapping("/boards/{seq}")
    public String get(@PathVariable Long seq, Model model) {
        model.addAttribute("post",boardService.getBoardById(seq));
        return "board/view";
    }

    @GetMapping("/boards/create")
    public String create() {
        return "board/create";
    }

    @PostMapping("/boards")
    public String create(@ModelAttribute Board board, Model model) {
        boardService.createBoard(board);
        return "redirect:/board/boards";
    }

    @GetMapping("boards/update/{seq}")
    public String update(@PathVariable Long seq, Model model) {
        model.addAttribute("post",boardService.getBoardById(seq));
        return "board/edit";
    }

    @PutMapping("boards")
    public String put(@ModelAttribute Board board, Model model) {
        boardService.updateBoard(board);
        return "redirect:/list";
    }

}
