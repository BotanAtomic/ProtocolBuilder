package com.ankamagames.dofus.network.types.game.dare;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.CharacterBasicMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DareInformations extends Object implements INetworkType {

    private int protocolId = 502;
    private Number dareId = 0;
    private CharacterBasicMinimalInformations creator;
    private Number subscriptionFee = 0;
    private Number jackpot = 0;
    private int maxCountWinners = 0;
    private Number endDate = 0;
    private boolean isPrivate = false;
    private int guildId = 0;
    private int allianceId = 0;
    private Vector<DareCriteria> criterions;
    private Number startDate = 0;
    private FuncTree _creatortree;
    private FuncTree _criterionstree;


    public int getTypeId() {
         return 502;
    }

    public DareInformations initDareInformations(Number param1,CharacterBasicMinimalInformations  param2,Number  param3,Number  param4,int  param5,Number  param6,boolean  param7,int  param8,int  param9,Vector<DareCriteria>  param10,Number  param11) {
         this.dareId = param1;
         this.creator = param2;
         this.subscriptionFee = param3;
         this.jackpot = param4;
         this.maxCountWinners = param5;
         this.endDate = param6;
         this.isPrivate = param7;
         this.guildId = param8;
         this.allianceId = param9;
         this.criterions = param10;
         this.startDate = param11;
         return this;
    }

    public void reset() {
         this.dareId = 0;
         this.creator = new CharacterBasicMinimalInformations();
         this.jackpot = 0;
         this.maxCountWinners = 0;
         this.endDate = 0;
         this.isPrivate = false;
         this.guildId = 0;
         this.allianceId = 0;
         this.criterions = new Vector.<DareCriteria>();
         this.startDate = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DareInformations(param1);
    }

    public void serializeAs_DareInformations(ICustomDataOutput param1) {
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         this.creator.serializeAs_CharacterBasicMinimalInformations(param1);
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element subscriptionFee.");
         }
         param1.writeVarLong(this.subscriptionFee);
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jackpot + ") on element jackpot.");
         }
         param1.writeVarLong(this.jackpot);
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
         {
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element maxCountWinners.");
         }
         param1.writeShort(this.maxCountWinners);
         if(this.endDate < 0 || this.endDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.endDate + ") on element endDate.");
         }
         param1.writeDouble(this.endDate);
         param1.writeBoolean(this.isPrivate);
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
         param1.writeShort(this.criterions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.criterions.length)
         {
            (this.criterions[_loc2_] as DareCriteria).serializeAs_DareCriteria(param1);
            _loc2_++;
         }
         if(this.startDate < 0 || this.startDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.startDate + ") on element startDate.");
         }
         param1.writeDouble(this.startDate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareInformations(param1);
    }

    public void deserializeAs_DareInformations(ICustomDataInput param1) {
         DareCriteria _loc4_ = null;
         this._dareIdFunc(param1);
         this.creator = new CharacterBasicMinimalInformations();
         this.creator.deserialize(param1);
         this._subscriptionFeeFunc(param1);
         this._jackpotFunc(param1);
         this._maxCountWinnersFunc(param1);
         this._endDateFunc(param1);
         this._isPrivateFunc(param1);
         this._guildIdFunc(param1);
         this._allianceIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareCriteria();
            _loc4_.deserialize(param1);
            this.criterions.push(_loc4_);
            _loc3_++;
         }
         this._startDateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareInformations(param1);
    }

    public void deserializeAsyncAs_DareInformations(FuncTree param1) {
         param1.addChild(this._dareIdFunc);
         this._creatortree = param1.addChild(this._creatortreeFunc);
         param1.addChild(this._subscriptionFeeFunc);
         param1.addChild(this._jackpotFunc);
         param1.addChild(this._maxCountWinnersFunc);
         param1.addChild(this._endDateFunc);
         param1.addChild(this._isPrivateFunc);
         param1.addChild(this._guildIdFunc);
         param1.addChild(this._allianceIdFunc);
         this._criterionstree = param1.addChild(this._criterionstreeFunc);
         param1.addChild(this._startDateFunc);
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareInformations.dareId.");
         }
    }

    private void _creatortreeFunc(ICustomDataInput param1) {
         this.creator = new CharacterBasicMinimalInformations();
         this.creator.deserializeAsync(this._creatortree);
    }

    private void _subscriptionFeeFunc(ICustomDataInput param1) {
         this.subscriptionFee = param1.readVarUhLong();
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element of DareInformations.subscriptionFee.");
         }
    }

    private void _jackpotFunc(ICustomDataInput param1) {
         this.jackpot = param1.readVarUhLong();
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jackpot + ") on element of DareInformations.jackpot.");
         }
    }

    private void _maxCountWinnersFunc(ICustomDataInput param1) {
         this.maxCountWinners = param1.readUnsignedShort();
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
         {
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element of DareInformations.maxCountWinners.");
         }
    }

    private void _endDateFunc(ICustomDataInput param1) {
         this.endDate = param1.readDouble();
         if(this.endDate < 0 || this.endDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.endDate + ") on element of DareInformations.endDate.");
         }
    }

    private void _isPrivateFunc(ICustomDataInput param1) {
         this.isPrivate = param1.readBoolean();
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of DareInformations.guildId.");
         }
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of DareInformations.allianceId.");
         }
    }

    private void _criterionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._criterionstree.addChild(this._criterionsFunc);
            _loc3_++;
         }
    }

    private void _criterionsFunc(ICustomDataInput param1) {
         DareCriteria _loc2_ = new DareCriteria();
         _loc2_.deserialize(param1);
         this.criterions.push(_loc2_);
    }

    private void _startDateFunc(ICustomDataInput param1) {
         this.startDate = param1.readDouble();
         if(this.startDate < 0 || this.startDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.startDate + ") on element of DareInformations.startDate.");
         }
    }

}