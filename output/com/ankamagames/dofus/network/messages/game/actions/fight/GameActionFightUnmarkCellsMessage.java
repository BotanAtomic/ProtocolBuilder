package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightUnmarkCellsMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5570;
    private boolean _isInitialized = false;
    private int markId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5570;
    }

    public GameActionFightUnmarkCellsMessage initGameActionFightUnmarkCellsMessage(int param1,Number  param2,int  param3) {
         super.initAbstractGameActionMessage(param1,param2);
         this.markId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.markId = 0;
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
         this.serializeAs_GameActionFightUnmarkCellsMessage(param1);
    }

    public void serializeAs_GameActionFightUnmarkCellsMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         param1.writeShort(this.markId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightUnmarkCellsMessage(param1);
    }

    public void deserializeAs_GameActionFightUnmarkCellsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._markIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightUnmarkCellsMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightUnmarkCellsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._markIdFunc);
    }

    private void _markIdFunc(ICustomDataInput param1) {
         this.markId = param1.readShort();
    }

}