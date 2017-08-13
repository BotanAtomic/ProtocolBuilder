package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.startup.StartupActionAddObject;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StartupActionAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6538;
    private boolean _isInitialized = false;
    private StartupActionAddObject newAction;
    private FuncTree _newActiontree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6538;
    }

    public StartupActionAddMessage initStartupActionAddMessage(StartupActionAddObject param1) {
         this.newAction = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.newAction = new StartupActionAddObject();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StartupActionAddMessage(param1);
    }

    public void serializeAs_StartupActionAddMessage(ICustomDataOutput param1) {
         this.newAction.serializeAs_StartupActionAddObject(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StartupActionAddMessage(param1);
    }

    public void deserializeAs_StartupActionAddMessage(ICustomDataInput param1) {
         this.newAction = new StartupActionAddObject();
         this.newAction.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StartupActionAddMessage(param1);
    }

    public void deserializeAsyncAs_StartupActionAddMessage(FuncTree param1) {
         this._newActiontree = param1.addChild(this._newActiontreeFunc);
    }

    private void _newActiontreeFunc(ICustomDataInput param1) {
         this.newAction = new StartupActionAddObject();
         this.newAction.deserializeAsync(this._newActiontree);
    }

}