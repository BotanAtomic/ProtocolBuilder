package package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class KohUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6439;
    private boolean _isInitialized = false;
    private Vector.<AllianceInformations> alliances = ;
    private Vector.<uint> allianceNbMembers = ;
    private Vector.<uint> allianceRoundWeigth = ;
    private Vector.<uint> allianceMatchScore = ;
    private BasicAllianceInformations allianceMapWinner = ;
    private int allianceMapWinnerScore = 0;
    private int allianceMapMyAllianceScore = 0;
    private Number nextTickTime = 0;
    private FuncTree _alliancestree = ;
    private FuncTree _allianceNbMemberstree = ;
    private FuncTree _allianceRoundWeigthtree = ;
    private FuncTree _allianceMatchScoretree = ;
    private FuncTree _allianceMapWinnertree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc5_ = 0;
    private int _loc11_ = 0;
    private int _loc12_ = 0;
    private int _loc13_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc8_ = param1.readUnsignedShort();
    private int _loc9_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6439;
    }

    public KohUpdateMessage initKohUpdateMessage(Vector.<AllianceInformations> param1,Vector.<uint>  param2,Vector.<uint>  param3,Vector.<uint>  param4,BasicAllianceInformations  param5,int  param6,int  param7,Number  param8) {
         this.alliances = param1;
         this.allianceNbMembers = param2;
         this.allianceRoundWeigth = param3;
         this.allianceMatchScore = param4;
         this.allianceMapWinner = param5;
         this.allianceMapWinnerScore = param6;
         this.allianceMapMyAllianceScore = param7;
         this.nextTickTime = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.alliances = new Vector.<AllianceInformations>();
         this.allianceNbMembers = new Vector.<uint>();
         this.allianceRoundWeigth = new Vector.<uint>();
         this.allianceMatchScore = new Vector.<uint>();
         this.allianceMapWinner = new BasicAllianceInformations();
         this.allianceMapMyAllianceScore = 0;
         this.nextTickTime = 0;
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
         this.serializeAs_KohUpdateMessage(param1);
    }

    public void serializeAs_KohUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.alliances.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alliances.length)
            (this.alliances[_loc2_] as AllianceInformations).serializeAs_AllianceInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KohUpdateMessage(param1);
    }

    public void deserializeAs_KohUpdateMessage(ICustomDataInput param1) {
         AllianceInformations _loc10_ = null;
         int _loc11_ = 0;
         int _loc12_ = 0;
         int _loc13_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc10_ = new AllianceInformations();
            _loc10_.deserialize(param1);
            this.alliances.push(_loc10_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KohUpdateMessage(param1);
    }

    public void deserializeAsyncAs_KohUpdateMessage(FuncTree param1) {
         this._alliancestree = param1.addChild(this._alliancestreeFunc);
         this._allianceNbMemberstree = param1.addChild(this._allianceNbMemberstreeFunc);
         this._allianceRoundWeigthtree = param1.addChild(this._allianceRoundWeigthtreeFunc);
         this._allianceMatchScoretree = param1.addChild(this._allianceMatchScoretreeFunc);
         this._allianceMapWinnertree = param1.addChild(this._allianceMapWinnertreeFunc);
         param1.addChild(this._allianceMapWinnerScoreFunc);
         param1.addChild(this._allianceMapMyAllianceScoreFunc);
         param1.addChild(this._nextTickTimeFunc);
    }

    private void _alliancestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._alliancestree.addChild(this._alliancesFunc);
            _loc3_++;
    }

    private void _alliancesFunc(ICustomDataInput param1) {
         AllianceInformations _loc2_ = new AllianceInformations();
         _loc2_.deserialize(param1);
         this.alliances.push(_loc2_);
    }

    private void _allianceNbMemberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._allianceNbMemberstree.addChild(this._allianceNbMembersFunc);
            _loc3_++;
    }

    private void _allianceNbMembersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of allianceNbMembers.");
    }

    private void _allianceRoundWeigthtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._allianceRoundWeigthtree.addChild(this._allianceRoundWeigthFunc);
            _loc3_++;
    }

    private void _allianceRoundWeigthFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of allianceRoundWeigth.");
    }

    private void _allianceMatchScoretreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._allianceMatchScoretree.addChild(this._allianceMatchScoreFunc);
            _loc3_++;
    }

    private void _allianceMatchScoreFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of allianceMatchScore.");
    }

    private void _allianceMapWinnertreeFunc(ICustomDataInput param1) {
         this.allianceMapWinner = new BasicAllianceInformations();
         this.allianceMapWinner.deserializeAsync(this._allianceMapWinnertree);
    }

    private void _allianceMapWinnerScoreFunc(ICustomDataInput param1) {
         this.allianceMapWinnerScore = param1.readVarUhInt();
         if(this.allianceMapWinnerScore < 0)
            throw new Exception("Forbidden value (" + this.allianceMapWinnerScore + ") on element of KohUpdateMessage.allianceMapWinnerScore.");
    }

    private void _allianceMapMyAllianceScoreFunc(ICustomDataInput param1) {
         this.allianceMapMyAllianceScore = param1.readVarUhInt();
         if(this.allianceMapMyAllianceScore < 0)
            throw new Exception("Forbidden value (" + this.allianceMapMyAllianceScore + ") on element of KohUpdateMessage.allianceMapMyAllianceScore.");
    }

    private void _nextTickTimeFunc(ICustomDataInput param1) {
         this.nextTickTime = param1.readDouble();
         if(this.nextTickTime < 0 || this.nextTickTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.nextTickTime + ") on element of KohUpdateMessage.nextTickTime.");
    }

}