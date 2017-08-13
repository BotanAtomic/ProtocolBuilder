package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightNoSpellCastMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6132;
    private boolean _isInitialized = false;
    private int spellLevelId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6132;
    }

    public GameActionFightNoSpellCastMessage initGameActionFightNoSpellCastMessage(int param1) {
         this.spellLevelId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.spellLevelId = 0;
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
         this.serializeAs_GameActionFightNoSpellCastMessage(param1);
    }

    public void serializeAs_GameActionFightNoSpellCastMessage(ICustomDataOutput param1) {
         if(this.spellLevelId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellLevelId + ") on element spellLevelId.");
         }
         param1.writeVarInt(this.spellLevelId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightNoSpellCastMessage(param1);
    }

    public void deserializeAs_GameActionFightNoSpellCastMessage(ICustomDataInput param1) {
         this._spellLevelIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightNoSpellCastMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightNoSpellCastMessage(FuncTree param1) {
         param1.addChild(this._spellLevelIdFunc);
    }

    private void _spellLevelIdFunc(ICustomDataInput param1) {
         this.spellLevelId = param1.readVarUhInt();
         if(this.spellLevelId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellLevelId + ") on element of GameActionFightNoSpellCastMessage.spellLevelId.");
         }
    }

}