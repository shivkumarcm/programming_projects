import './App.css';
import {useState} from 'react'

function SimpleButton() {
  const [count, setCount] = useState(0)

  function clickHandler() {
    setCount(count+1)
    //alert("You clicked me!")
  }
  return <button onClick={clickHandler}>Simple Button clicked {count} times</button>
}

const items = ["Item 1", "Item 2"]

function SimpleList() {
  const listItems = items.map(item => (<li>{item}</li>))
  return (<ul>{listItems}</ul>)
}

function GenericButton({name, count, handleClick}) {
  return (
    <button onClick={handleClick}>{name} Button {count}</button>
  )
}

function ButtonPair() {
  const [count, setCount] = useState(0);

  function clickHandler() {
    setCount(count + 1)
  }

  return (
    <div>
      <p>Button Pair</p>
      <GenericButton name="Left" count={count} handleClick={clickHandler}/>
      <GenericButton name="Right" count={count} handleClick={clickHandler}/>
    </div>
  )

}


function App() {
  return (
    <div className="App">
      <SimpleButton/>
      <p/>
      <SimpleButton/>
      <SimpleList/>
      <p/>
      <ButtonPair/>
    </div>
  );
}

export default App;
