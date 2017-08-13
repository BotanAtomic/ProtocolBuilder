package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightDispellSpellMessage extends GameActionFightDispellMessage implements INetworkMessage {

    private int protocolId = 6176;
    private boolean _isInitialized = false;
    private int spellId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6176;
    }

    public GameActionFightDispellSpellMessage initGameActionFightDispellSpellMessage(int param1,Number  param2,Number  param3,int  param4) {
         super.initGameActionFightDispellMessage(param1,param2,param3);
         this.spellId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.spellId = 0;
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
         this.serializeAs_GameActionFightDispellSpellMessage(param1);
    }

    public void serializeAs_GameActionFightDispellSpellMessage(ICustomDataOutput param1) {
         super.serializeAs_GameActionFightDispellMessage(param1);
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightDispellSpellMessage(param1);
    }

    public void deserializeAs_GameActionFightDispellSpellMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._spellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightDispellSpellMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightDispellSpellMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._spellIdFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameActionFightDispellSpellMessage.spellId.");
    }

}