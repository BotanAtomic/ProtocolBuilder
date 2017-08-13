package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberGeoPosition;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyLocateMembersMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5595;
    private boolean _isInitialized = false;
    private Vector.<PartyMemberGeoPosition> geopositions = ;
    private FuncTree _geopositionstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5595;
    }

    public PartyLocateMembersMessage initPartyLocateMembersMessage(int param1,Vector.<PartyMemberGeoPosition>  param2) {
         super.initAbstractPartyMessage(param1);
         this.geopositions = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.geopositions = new Vector.<PartyMemberGeoPosition>();
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
         this.serializeAs_PartyLocateMembersMessage(param1);
    }

    public void serializeAs_PartyLocateMembersMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeShort(this.geopositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.geopositions.length)
            (this.geopositions[_loc2_] as PartyMemberGeoPosition).serializeAs_PartyMemberGeoPosition(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyLocateMembersMessage(param1);
    }

    public void deserializeAs_PartyLocateMembersMessage(ICustomDataInput param1) {
         PartyMemberGeoPosition _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new PartyMemberGeoPosition();
            _loc4_.deserialize(param1);
            this.geopositions.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyLocateMembersMessage(param1);
    }

    public void deserializeAsyncAs_PartyLocateMembersMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._geopositionstree = param1.addChild(this._geopositionstreeFunc);
    }

    private void _geopositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._geopositionstree.addChild(this._geopositionsFunc);
            _loc3_++;
    }

    private void _geopositionsFunc(ICustomDataInput param1) {
         PartyMemberGeoPosition _loc2_ = new PartyMemberGeoPosition();
         _loc2_.deserialize(param1);
         this.geopositions.push(_loc2_);
    }

}