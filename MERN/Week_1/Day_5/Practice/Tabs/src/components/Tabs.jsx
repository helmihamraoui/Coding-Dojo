import React, { useState } from 'react';

const Tabs = ({ tabs }) => {
    const [selectedIndex, setSelectedIndex] = useState(0);

        return (
    <div className="tabs-container">
        <div className="tabs-header d-flex">
        {tabs.map((tab, index) => (
            <button
            key={index}
            className={`tab-header ${selectedIndex === index ? 'active' : ''}`}
            onClick={() => setSelectedIndex(index)}
            >
            {tab.name}
            </button>
        ))}
        </div>
        <div className="tab-content">
        {tabs[selectedIndex] && <p>{tabs[selectedIndex].content}</p>}
        </div>
    </div>
  );
};

export default Tabs;
