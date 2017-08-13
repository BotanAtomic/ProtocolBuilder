package package com.ankamagames.dofus.network.messages.game.context.roleplay.visual;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlaySpellAnimMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6114;
    private boolean _isInitialized = false;
    private Number casterId = 0;
    private int targetCellId = 0;
    private int spellId = 0;
    private int spellLevel = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6114;
    }

    public GameRolePlaySpellAnimMessage initGameRolePlaySpellAnimMessage(Number param1,int  param2,int  param3,int  param4) {
         this.casterId = param1;
         this.targetCellId = param2;
         this.spellId = param3;
         this.spellLevel = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.casterId = 0;
         this.targetCellId = 0;
         this.spellId = 0;
         this.spellLevel = 0;
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
         this.serializeAs_GameRolePlaySpellAnimMessage(param1);
    }

    public void serializeAs_GameRolePlaySpellAnimMessage(ICustomDataOutput param1) {
         if(this.casterId < 0 || this.casterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.casterId + ") on element casterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlaySpellAnimMessage(param1);
    }

    public void deserializeAs_GameRolePlaySpellAnimMessage(ICustomDataInput param1) {
         this._casterIdFunc(param1);
         this._targetCellIdFunc(param1);
         this._spellIdFunc(param1);
         this._spellLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlaySpellAnimMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlaySpellAnimMessage(FuncTree param1) {
         param1.addChild(this._casterIdFunc);
         param1.addChild(this._targetCellIdFunc);
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._spellLevelFunc);
    }

    private void _casterIdFunc(ICustomDataInput param1) {
         this.casterId = param1.readVarUhLong();
         if(this.casterId < 0 || this.casterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.casterId + ") on element of GameRolePlaySpellAnimMessage.casterId.");
    }

    private void _targetCellIdFunc(ICustomDataInput param1) {
         this.targetCellId = param1.readVarUhShort();
         if(this.targetCellId < 0 || this.targetCellId > 559)
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameRolePlaySpellAnimMessage.targetCellId.");
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameRolePlaySpellAnimMessage.spellId.");
    }

    private void _spellLevelFunc(ICustomDataInput param1) {
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of GameRolePlaySpellAnimMessage.spellLevel.");
    }

}