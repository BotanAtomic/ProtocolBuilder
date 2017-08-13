package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamMemberCharacterInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 13;
    private String name = "";
    private int level = 0;


    public int getTypeId() {
         return 13;
    }

    public FightTeamMemberCharacterInformations initFightTeamMemberCharacterInformations(Number param1,String  param2,int  param3) {
         super.initFightTeamMemberInformations(param1);
         this.name = param2;
         this.level = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberCharacterInformations(param1);
    }

    public void serializeAs_FightTeamMemberCharacterInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
         param1.writeUTF(this.name);
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberCharacterInformations(param1);
    }

    public void deserializeAs_FightTeamMemberCharacterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberCharacterInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberCharacterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
         param1.addChild(this._levelFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberCharacterInformations.level.");
    }

}