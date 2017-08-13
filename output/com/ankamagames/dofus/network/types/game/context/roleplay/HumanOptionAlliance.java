package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionAlliance extends HumanOption implements INetworkType {

    private int protocolId = 425;
    private AllianceInformations allianceInformations;
    private int aggressable = 0;
    private FuncTree _allianceInformationstree;


    public void serialize(ICustomDataOutput param1) {
         this.allianceInformations.serializeAs_AllianceInformations(param1);
         param1.writeByte(this.aggressable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allianceInformations = new AllianceInformations();
         this.allianceInformations.deserialize(param1);
         this.aggressable = param1.readByte();
         if(this.aggressable < 0)
         {
            throw new Exception("Forbidden value (" + this.aggressable + ") on element of HumanOptionAlliance.aggressable.");
         }
    }

}