package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AllianceFactSheetInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6408;
    private boolean _isInitialized = false;
    private Vector<AllianceFactSheetInformations> alliances;
    private FuncTree _alliancestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6408;
    }

    public AllianceListMessage initAllianceListMessage(Vector<AllianceFactSheetInformations> param1) {
         this.alliances = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.alliances = new Vector.<AllianceFactSheetInformations>();
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
         this.serializeAs_AllianceListMessage(param1);
    }

    public void serializeAs_AllianceListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.alliances.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alliances.length)
         {
            (this.alliances[_loc2_] as AllianceFactSheetInformations).serializeAs_AllianceFactSheetInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceListMessage(param1);
    }

    public void deserializeAs_AllianceListMessage(ICustomDataInput param1) {
         AllianceFactSheetInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new AllianceFactSheetInformations();
            _loc4_.deserialize(param1);
            this.alliances.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceListMessage(param1);
    }

    public void deserializeAsyncAs_AllianceListMessage(FuncTree param1) {
         this._alliancestree = param1.addChild(this._alliancestreeFunc);
    }

    private void _alliancestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._alliancestree.addChild(this._alliancesFunc);
            _loc3_++;
         }
    }

    private void _alliancesFunc(ICustomDataInput param1) {
         AllianceFactSheetInformations _loc2_ = new AllianceFactSheetInformations();
         _loc2_.deserialize(param1);
         this.alliances.push(_loc2_);
    }

}