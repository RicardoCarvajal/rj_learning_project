import { ToDoItem } from './ToDoItem';
import { ToDoCounter } from './ToDoCounter'; 
import { ToDoSearch } from './ToDoSearch';
import { ToDoList } from './ToDoList';
import { CreateToDoButton } from './CreateToDoButton';
import './App.css';

function App() {
  return (
    <div className="App">

      <ToDoCounter />
      <ToDoSearch />

      <ToDoList>
        <ToDoItem />
        <ToDoItem />
        <ToDoItem />
      </ToDoList>
      
      <CreateToDoButton />

    </div>
  );
}

export default App;
