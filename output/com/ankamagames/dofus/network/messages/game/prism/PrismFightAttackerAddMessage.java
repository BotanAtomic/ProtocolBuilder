package package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PrismFightAttackerAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5893;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int fightId = 0;
    private CharacterMinimalPlusLookInformations attacker = ;
    private FuncTree _attackertree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5893;
    }

    public PrismFightAttackerAddMessage initPrismFightAttackerAddMessage(int param1,int  param2,CharacterMinimalPlusLookInformations  param3) {
         this.subAreaId = param1;
         this.fightId = param2;
         this.attacker = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.fightId = 0;
         this.attacker = new CharacterMinimalPlusLookInformations();
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
         this.serializeAs_PrismFightAttackerAddMessage(param1);
    }

    public void serializeAs_PrismFightAttackerAddMessage(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightAttackerAddMessage(param1);
    }

    public void deserializeAs_PrismFightAttackerAddMessage(ICustomDataInput param1) {
         this._subAreaIdFunc(param1);
         this._fightIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.attacker = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
         this.attacker.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismFightAttackerAddMessage(param1);
    }

    public void deserializeAsyncAs_PrismFightAttackerAddMessage(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._fightIdFunc);
         this._attackertree = param1.addChild(this._attackertreeFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightAttackerAddMessage.subAreaId.");
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readVarUhShort();
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element of PrismFightAttackerAddMessage.fightId.");
    }

    private void _attackertreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.attacker = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
         this.attacker.deserializeAsync(this._attackertree);
    }

}