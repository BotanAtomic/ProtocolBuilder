package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorBasicInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorMovementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5633;
    private boolean _isInitialized = false;
    private int movementType = 0;
    private TaxCollectorBasicInformations basicInfos;
    private Number playerId = 0;
    private String playerName = "";
    private FuncTree _basicInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5633;
    }

    public TaxCollectorMovementMessage initTaxCollectorMovementMessage(int param1,TaxCollectorBasicInformations  param2,Number  param3,String  param4) {
         this.movementType = param1;
         this.basicInfos = param2;
         this.playerId = param3;
         this.playerName = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.movementType = 0;
         this.basicInfos = new TaxCollectorBasicInformations();
         this.playerName = "";
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
         this.serializeAs_TaxCollectorMovementMessage(param1);
    }

    public void serializeAs_TaxCollectorMovementMessage(ICustomDataOutput param1) {
         param1.writeByte(this.movementType);
         this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorMovementMessage(param1);
    }

    public void deserializeAs_TaxCollectorMovementMessage(ICustomDataInput param1) {
         this._movementTypeFunc(param1);
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserialize(param1);
         this._playerIdFunc(param1);
         this._playerNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorMovementMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorMovementMessage(FuncTree param1) {
         param1.addChild(this._movementTypeFunc);
         this._basicInfostree = param1.addChild(this._basicInfostreeFunc);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._playerNameFunc);
    }

    private void _movementTypeFunc(ICustomDataInput param1) {
         this.movementType = param1.readByte();
         if(this.movementType < 0)
         {
            throw new Exception("Forbidden value (" + this.movementType + ") on element of TaxCollectorMovementMessage.movementType.");
         }
    }

    private void _basicInfostreeFunc(ICustomDataInput param1) {
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserializeAsync(this._basicInfostree);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of TaxCollectorMovementMessage.playerId.");
         }
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

}