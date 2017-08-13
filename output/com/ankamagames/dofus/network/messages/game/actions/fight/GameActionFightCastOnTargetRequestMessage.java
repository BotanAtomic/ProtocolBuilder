package package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightCastOnTargetRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6330;
    private boolean _isInitialized = false;
    private int spellId = 0;
    private Number targetId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6330;
    }

    public GameActionFightCastOnTargetRequestMessage initGameActionFightCastOnTargetRequestMessage(int param1,Number  param2) {
         this.spellId = param1;
         this.targetId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.spellId = 0;
         this.targetId = 0;
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
         this.serializeAs_GameActionFightCastOnTargetRequestMessage(param1);
    }

    public void serializeAs_GameActionFightCastOnTargetRequestMessage(ICustomDataOutput param1) {
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightCastOnTargetRequestMessage(param1);
    }

    public void deserializeAs_GameActionFightCastOnTargetRequestMessage(ICustomDataInput param1) {
         this._spellIdFunc(param1);
         this._targetIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightCastOnTargetRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightCastOnTargetRequestMessage(FuncTree param1) {
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._targetIdFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameActionFightCastOnTargetRequestMessage.spellId.");
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightCastOnTargetRequestMessage.targetId.");
    }

}