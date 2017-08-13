package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightMarkCellsMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5540;
    private boolean _isInitialized = false;
    private GameActionMark mark = ;
    private FuncTree _marktree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5540;
    }

    public GameActionFightMarkCellsMessage initGameActionFightMarkCellsMessage(int param1,Number  param2,GameActionMark  param3) {
         super.initAbstractGameActionMessage(param1,param2);
         this.mark = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.mark = new GameActionMark();
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
         this.serializeAs_GameActionFightMarkCellsMessage(param1);
    }

    public void serializeAs_GameActionFightMarkCellsMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         this.mark.serializeAs_GameActionMark(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightMarkCellsMessage(param1);
    }

    public void deserializeAs_GameActionFightMarkCellsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.mark = new GameActionMark();
         this.mark.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightMarkCellsMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightMarkCellsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._marktree = param1.addChild(this._marktreeFunc);
    }

    private void _marktreeFunc(ICustomDataInput param1) {
         this.mark = new GameActionMark();
         this.mark.deserializeAsync(this._marktree);
    }

}