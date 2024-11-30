import React from 'react';
import Tabs from './components/Tabs';
import './App.css'

function App() {
  const tabItems = [
    { name: 'Tab 1', content: 'Content of Tab 1' },
    { name: 'Tab 2', content: 'Content of Tab 2' },
    { name: 'Tab 3', content: 'Content of Tab 3' },
    { name: 'Tab 4', content: 'Content of Tab 4' },
  ];

  return (
    <div className="container mt-5">
      <Tabs tabs={tabItems} />
    </div>
  );
}

export default App;
